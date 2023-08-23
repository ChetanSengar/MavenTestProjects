import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {

  employee: Employee = new Employee();
  submitted = false;
  errorMessage = 'Error in saving employee data, try again !';

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }

  save(employee: Employee) {
    this.employeeService.createEmployee(employee)
      .subscribe({
        next: data => {
          console.log(data);
          this.employee = new Employee();
          setTimeout(() => { this.submitted = false; }, 3000);
        },
        error: err => {
          console.error(err);
          this.errorMessage = err;
        }
      });
  }

  onSubmit(employee: Employee) {
    this.submitted = true;
    this.save(employee);
  }
}
