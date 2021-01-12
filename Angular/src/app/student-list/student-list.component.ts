import { StudentDetailComponent } from '../student-detail/student-detail.component';
import { Observable } from "rxjs";
import { StudentService } from "../student.service";
import { Student } from "../student";
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students: Observable<Student[]>;

  constructor(private studentService: StudentService,
    private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.students = this.studentService.getStudentsList();
  }

  deleteStudent(id: number) {
    this.studentService.deleteStudent(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  studentDetails(id: number){
    this.router.navigate(['details', id]);
  }
  
  updateStudent(id: number){
    this.router.navigate(['update', id]);
  }
}
