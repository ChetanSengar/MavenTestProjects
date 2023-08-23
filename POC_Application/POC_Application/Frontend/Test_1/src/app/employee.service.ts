import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Employee } from './employee';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { environment } from './env';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8080';
  //  private baseUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient, private router: Router) { }

  getEmployeeList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/listAllEmployee`).pipe(catchError(this.handleError));
  }

  createEmployee(employee: Employee): Observable<any> {
    return this.http.post(`${this.baseUrl}/saveEmployee`, employee).pipe(catchError(this.handleError));
  }

  updateEmployee(id: number, employee: Employee): Observable<any> {
    return this.http.post(`${this.baseUrl}/updateEmployee`, employee).pipe(catchError(this.handleError));
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deleteEmployee/${id}`, { responseType: 'text' }).pipe(catchError(this.handleError));
  }

  getEmployee(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/getEmployeeById/${id}`).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
        if (error.status == 0) {  // If the backend API is not available, the status will be 0
          // alert("Backend API is not available. Please check your server.");  // Show an alert
          Swal.fire('Error: Backend API', 'Backend API is not available. Please check your server.', 'error');
        }
    }
    return throwError(() => 'Something bad happened; please try again later.');
  }
}
