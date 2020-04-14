import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ItemService {

  private baseUrl = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) { }

  createItem(item: object): Observable<object> {
    return this.http.post(`${this.baseUrl}` + 'create-item', item);
  }
}                                           