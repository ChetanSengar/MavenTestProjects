import { Component, OnInit, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Employee } from '../employee';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent implements OnInit, OnChanges {

  @Input() employee: Employee = new Employee();
  @Output() formSubmit = new EventEmitter();

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['employee'].currentValue !== changes['employee'].previousValue) {
      this.updateForm();
    }
  }
  updateForm() {
    this.employeeForm.patchValue({
      'first_name': this.employee.first_name,
      'last_name': this.employee.last_name,
      'email': this.employee.email,
      'phone_number': this.employee.phone_number,
      'job_title': this.employee.job_title,
      'department': this.employee.department
    });
  }

  employeeForm: FormGroup = new FormGroup({});

  ngOnInit() {
    this.employeeForm = new FormGroup({
      'first_name': new FormControl(this.employee.first_name, [Validators.required]),
      'last_name': new FormControl(this.employee.last_name, [Validators.nullValidator]),
      'email': new FormControl(this.employee.email, [Validators.required, Validators.email]),
      'phone_number': new FormControl(this.employee.phone_number, [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(10),
        Validators.pattern('^[0-9]*$')]),
      'job_title': new FormControl(this.employee.job_title, [Validators.required]),
      'department': new FormControl(this.employee.department, [Validators.required])
    });
  }
  onSubmit() {
    if (this.employeeForm.valid) {
      this.formSubmit.emit(this.employeeForm.value);
    }
  }
}




