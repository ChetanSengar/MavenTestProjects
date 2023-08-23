import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TmsDataService {

  private apiUrl = 'http://localhost:8080'; // adjust if your backend runs on a different port

  constructor(private http: HttpClient) { }

  getTasks() {
    return this.http.get(`${this.apiUrl}/tasks`);
  }

  getUsers() {
    return this.http.get(`${this.apiUrl}/users`);
  }
}
