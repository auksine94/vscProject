import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class JoyService {

  private baseUrl = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) { }

  getJoyList(): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'joys-list');
  }

  createJoy(joy: object): Observable<object> {
    return this.http.post(`${this.baseUrl}` + 'create-joy', joy);
  }

  getJoy(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/joy/${id}`);
  }

  updateJoy(id: number, value: any): Observable<Object> {
    return this.http.post(`${this.baseUrl}/update-joy/${id}`, value);
  }

  deleteJoy(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete-joy/${id}`, { responseType: 'text' });
  }
}                                           