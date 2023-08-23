import { Component, OnInit } from '@angular/core';
import { TmsDataService } from '../tms-data.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: any[] = [];

  constructor(private tmsDataService: TmsDataService) { }

  ngOnInit(): void {
    this.fetchUsers();
  }

  fetchUsers(): void {
    this.tmsDataService.getUsers().subscribe(
      (data: any) => {
        this.users = data;
      },
      error => {
        console.error('There was an error fetching users!', error);
      }
    );
  }
}
