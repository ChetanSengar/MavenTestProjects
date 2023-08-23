import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { EmployeeEditComponent } from './employee-edit.component';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { of } from 'rxjs';

describe('EmployeeEditComponent', () => {
  let component: EmployeeEditComponent;
  let employeeService: EmployeeService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule, HttpClientTestingModule],
      providers: [EmployeeEditComponent, EmployeeService]
    });

    // Get the injected instances
    component = TestBed.inject(EmployeeEditComponent);
    employeeService = TestBed.inject(EmployeeService);

    // Creating and setting up the employee
    let employee = new Employee();
    employee.id = 1;
    employee.first_name = 'Chetan Singh';
    employee.last_name = 'sengar';
    employee.email = 'chetan@gmail.com';
    employee.phone_number = '8979861387';
    employee.job_title = 'SSE';
    employee.department = 'IT';

    spyOn(employeeService, 'getEmployee').and.returnValue(of(employee));
  });

  it('should fetch employee details on init', () => {
    component.ngOnInit();

    let expectedEmployee = new Employee();
    expectedEmployee.id = 1;
    expectedEmployee.first_name = 'Chetan Singh';
    expectedEmployee.last_name = 'sengar';
    expectedEmployee.email = 'chetan@gmail.com';
    expectedEmployee.phone_number = '8979861387';
    expectedEmployee.job_title = 'SSE';
    expectedEmployee.department = 'IT';

    expect(component.employee).toEqual(expectedEmployee);
  });
});
