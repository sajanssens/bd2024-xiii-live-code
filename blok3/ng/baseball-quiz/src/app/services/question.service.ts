import {Injectable} from '@angular/core';
import {Question} from "../domain/Question";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {serverUrl} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private url = serverUrl
  private resource = '/questions';
  private questionsPath = this.url + this.resource;

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<Question[]> { // R
    return this.httpClient.get<Question[]>(this.questionsPath);
  }

  find(id: number): Observable<Question> { // R
    return this.httpClient.get<Question>(`${this.questionsPath}/${id}`);
  }

  add(q: Question) { // C
    return this.httpClient.post<Question>(this.questionsPath, q, {observe: 'response'} /* = to receive the full httpresponse including the token as http header, instead of only the body */);
  }

  remove(id: number) { // D
    return this.httpClient.delete<Question>(`${this.questionsPath}/${id}`);
  }

  update(id: number, q: Question) { // U
    return this.httpClient.put<Question>(`${this.questionsPath}/${id}`, q, {observe: 'response'});
  }
}
