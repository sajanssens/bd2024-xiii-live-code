import {AfterContentInit, Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {ContactService} from '../../services/contact.service';
import {GENS} from '../../domain/contact/gender';
import {emailValidator} from '../../util/util';
import {LANGS, Language} from '../../domain/contact/language';
import {JsonPipe} from "@angular/common";
import {Contact} from "../../domain/contact/contact";

@Component({
  selector: 'bq-contact-form', // de html-tag die je gebruikt om dit component ergens in een ander component te plaatsen
  templateUrl: './contact-form.component.html',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    JsonPipe
  ],
  styleUrls: ['./contact-form.component.scss']
})
export class ContactFormComponent implements OnInit {

  genders = GENS
  languages = LANGS
  contact = {} as Contact

  contactForm!: FormGroup
  icon: "plus" | "minus" = "plus"

  constructor(
    private contactService: ContactService,
    private fb: FormBuilder) {
  }

    ngOnInit(): void {
    this.initForm();
    this.getContact();
  }

  private getContact() {
    this.contactService.get(42)
      .subscribe(contact => {
        this.contact = contact
        this.contactForm.patchValue(contact)
      });
    this.contact.gender.id = 1
  }

  private initForm() {
    this.contactForm = this.fb.group({
      firstName: this.fb.control(''),
      surname: this.fb.control(''),
      email: this.fb.control('', [Validators.required, emailValidator]),
      gender: this.fb.control(''),
      languages: this.fb.array([])
    });

    this.initLanguagesControls();
  }

  get languagesFormArray(): FormArray {
    return this.contactForm.get('languages') as FormArray;
  }

  private initLanguagesControls(): void {
    this.languages.forEach(() => this.languagesFormArray.push(new FormControl()));
  }

  submit(): void {
    this.contactForm.value.languages = this.contactForm.value.languages
      .map((checked: boolean, i: number) => checked ? this.languages[i] : null)
      .filter((lang: Language) => lang !== null);

    this.contactService.add(this.contactForm.value);
    this.contactForm.reset();
    this.toggleForm();
  }

  toggleForm(): void {
    this.icon = (this.icon === "plus") ? "minus" : "plus";
  }

  get email() {
    return this.contactForm.get('email')
  }
}
