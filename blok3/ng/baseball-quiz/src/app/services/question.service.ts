import {Injectable} from '@angular/core';
import {Question} from "../domain/Question";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {serverUrl} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  private host = serverUrl
  private resourcePath = '/questions';
  private questions = this.host + this.resourcePath;

  private _questionsUpdated$ = new Subject<Question[]>()

  constructor(private httpClient: HttpClient) {
  }

  findAll(): void { // R
    this.httpClient.get<Question[]>(this.questions).subscribe((r) => this._questionsUpdated$.next(r));
  }

  find(id: number): Observable<Question> { // R
    return this.httpClient.get<Question>(`${this.questions}/${id}`);
  }

  add(q: Question) { // C
    this.httpClient.post<Question>(this.questions, q, {observe: 'response'} /* = to receive the full httpresponse including the token as http header, instead of only the body */)
      .subscribe(() => this.findAll());
  }

  remove(id: number) { // D
    this.httpClient.delete<Question>(`${this.questions}/${id}`)
      .subscribe(() => this.findAll());
  }

  update(q: Question) { // U
    this.httpClient.put<Question>(`${this.questions}/${q.id}`, q, {observe: 'response'})
      .subscribe(() => this.findAll());
  }


  search(term: string): void {
    this.httpClient.get<Question[]>(`${this.questions}?q=${term}`).subscribe(
      (result) => this._questionsUpdated$.next(result)
    )
  }

  get questionsUpdated$(): Subject<Question[]> {
    return this._questionsUpdated$;
  }
}
