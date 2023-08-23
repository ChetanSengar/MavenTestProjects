import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[] | undefined;
  errorMessage = 'Something bad happend while fetching list of employees. Try again.';

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();

    this.router.events.pipe(
      filter((event): event is NavigationEnd => event instanceof NavigationEnd)
    ).subscribe((event: NavigationEnd) => {
      this.getEmployees();
    });
  }

  getEmployees() {
    this.employeeService.getEmployeeList()
      .subscribe({
        next: data => {
          this.employees = data;
          console.log(data);
        },
        error: err => {
          console.error(err);
          this.errorMessage = err;
        }
      });
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id)
      .subscribe({
        next: () => {
          this.getEmployees();
          console.log('Delete operation completed, reloading data');
          // setTimeout(() =>{
          // },500);
        },
        error: err => {
          console.error(err);
          this.errorMessage = err;
        }
      });
  }

  editEmployee(id: number) {
    this.router.navigate(['/edit', id]);  // For to Navigate to edit route
  }
}

