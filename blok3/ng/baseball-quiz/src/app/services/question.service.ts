import {Injectable} from '@angular/core';
import {Question} from "../domain/Question";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<Question[]> { // R
    return this.httpClient.get<Question[]>('http://localhost:3000/questions');
  }

  find(id: number): Observable<Question> { // R
    return this.httpClient.get<Question>(`http://localhost:3000/questions/${id}`);
  }

  add(q: Question) { // C
    return this.httpClient.post<Question>(`http://localhost:3000/questions`, q, {observe: 'response'} /* = to receive the full httpresponse including the token as http header, instead of only the body */);
  }

  remove(id: number) { // D
    return this.httpClient.delete<Question>(`http://localhost:3000/questions/${id}`);
  }

  update(id: number, q: Question) { // U
    return this.httpClient.put<Question>(`http://localhost:3000/questions/${id}`, q, {observe: 'response'});
  }
}
