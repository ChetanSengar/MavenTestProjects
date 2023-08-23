import { Component, OnInit } from '@angular/core';
import { TmsDataService } from '../tms-data.service';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  tasks: any[] = [];

  constructor(private tmsDataService: TmsDataService) { }

  ngOnInit(): void {
    this.fetchTasks();
  }

  fetchTasks(): void {
    this.tmsDataService.getTasks().subscribe(
      (data: any) => {
        this.tasks = data;
      },
      error => {
        console.error('There was an error fetching tasks!', error);
      }
    );
  }
}
