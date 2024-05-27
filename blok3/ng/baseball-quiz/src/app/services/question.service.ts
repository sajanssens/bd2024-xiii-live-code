import {Injectable} from '@angular/core';
import {Question} from "../domain/Question";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {serverUrl} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  private url = serverUrl


  private resource = '/questions';
  private questionsPath = this.url + this.resource;
  private _questionsUpdated$ = new Subject<Question[]>()

  constructor(private httpClient: HttpClient) {
  }

   findAll(): void { // R
    this.httpClient.get<Question[]>(this.questionsPath).subscribe((r) => this._questionsUpdated$.next(r));
  }

  find(id: number): Observable<Question> { // R
    return this.httpClient.get<Question>(`${this.questionsPath}/${id}`);
  }

  add(q: Question) { // C
    this.httpClient.post<Question>(this.questionsPath, q, {observe: 'response'} /* = to receive the full httpresponse including the token as http header, instead of only the body */)
      .subscribe(() => this.findAll());
  }

  remove(id: number) { // D
    this.httpClient.delete<Question>(`${this.questionsPath}/${id}`)
      .subscribe(() => this.findAll());
  }

  update(q: Question) { // U
    this.httpClient.put<Question>(`${this.questionsPath}/${q.id}`, q, {observe: 'response'})
      .subscribe(() => this.findAll());
  }

  get questionsUpdated$(): Subject<Question[]> {
    return this._questionsUpdated$;
  }
}
