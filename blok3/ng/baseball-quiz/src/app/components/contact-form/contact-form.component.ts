import {Component, Input, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {ContactService} from '../../services/contact.service';
import {Contact} from '../../domain/contact/contact';
import {Gender, GENS} from '../../domain/contact/gender';
import {emailValidator} from '../../util/util';
import {LANGS, Language} from '../../domain/contact/language';
import {JsonPipe} from "@angular/common";

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
  @Input() contact?: Contact;

  genders = GENS
  languages = LANGS

  contactForm!: FormGroup
  plusMinus: "plus" | "minus" = "plus"

  constructor(private contactService: ContactService, private fb: FormBuilder) {
  }

  get languagesFormArray(): FormArray {
    return this.contactForm.get('languages') as FormArray;
  }

  ngOnInit(): void {
    const fb = this.fb;
    this.contactForm = fb.group({
      firstName: fb.control(''),
      surname: fb.control(''),
      email: fb.control('', [Validators.required, emailValidator]),
      gender: fb.control(''),
      languages: fb.array([])
    });
    this.initLanguagesControls();
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
    this.plusMinus = (this.plusMinus === "plus") ? "minus" : "plus";
  }

  get email() {
    return this.contactForm.get('email')
  }
}
