import {Injectable} from '@angular/core';
import {Question} from "../domain/Question";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {


  constructor(private http: HttpClient) {
  }

  findAll(): Observable<Question[]> {
    return this.http.get<Question[]>('http://localhost:3000/questions');
  }

  find(id: number): Observable<Question> {
    return this.http.get<Question>(`http://localhost:3000/questions/${id}`);
  }
}
