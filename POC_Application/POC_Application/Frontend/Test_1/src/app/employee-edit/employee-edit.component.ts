import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {

  id !: number;
  employee: Employee = new Employee();
  errorMessage = '!Something Bad Happened, please try again later!';

  constructor(private employeeService: EmployeeService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.employeeService.getEmployee(this.id)
    .subscribe({
      next: data => {
        this.employee = data;
      }, error: error => {
        console.log(error),
        this.errorMessage=error;
      }
    });
  }

  onSubmit(employee: Employee) {
    employee.id = this.id;
    this.employeeService.updateEmployee(this.id, employee)
      .subscribe({
        next: data => {
          console.log(data);
          this.gotoList(); // Move this line inside here
        },
        error: error => console.log(error)
      });
    // this.gotoList();
  }

  gotoList() {
    this.router.navigate(['/list']);
  }
}
