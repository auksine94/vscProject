import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from "rxjs";
import { FormControl, FormGroup } from '@angular/forms';

import { JoyService } from '../joy.service';
import { Joy } from '../joy';

@Component({
  selector: 'app-joy-list',
  templateUrl: './joy-list.component.html'
})
export class JoyListComponent implements OnInit {

  constructor(private joyservice: JoyService) { }

  joysArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  joys: Observable<Joy[]>;
  joy: Joy = new Joy();
  deleteMessage = false;
  joyList: any;
  isUpdated = false;

  ngOnInit() {
    this.isUpdated = false;
    this.dtOptions = {
      pageLength: 3,
      stateSave: true,
      lengthMenu: [[3, 5, 7, -1], [3, 5, 7, "all"]],
      processing: true
    };
    this.joyservice.getJoyList().subscribe(data => {
      this.joys = data;
      this.dtTrigger.next();
    })
  }

  updateJoy(id: number) {
    this.joyservice.getJoy(id)
      .subscribe(
        data => {
          this.joyList = data
        },
        error => console.log(error));
  }

  deleteJoy(id: number) {
    this.joyservice.deleteJoy(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage = true;
          this.joyservice.getJoyList().subscribe(data => {
            this.joys = data
          })
        },
        error => console.log(error));
  }

  joyUpdateForm = new FormGroup({
    joy_id: new FormControl(),
    joy_name: new FormControl(),
    joy_desc: new FormControl(),
    joy_flag: new FormControl(),
    joy_img_url: new FormControl()
  });

  updateJoyFinal(updjoy) {
    this.joy = new Joy();
    this.joy.joy_id = this.JoyId.value;
    this.joy.joy_name = this.JoyName.value;
    this.joy.joy_desc = this.JoyDescription.value;
    this.joy.joy_flag = this.JoyFlag.value;
    this.joy.joy_img_url = this.JoyImgUrl.value;
    console.log(this.JoyFlag.value);

    this.joyservice.updateJoy(this.joy.joy_id, this.joy).subscribe(
      data => {
        this.isUpdated = true;
        this.joyservice.getJoyList().subscribe(data => {
          this.joys = data
        })
      },
      error => console.log(error));
  }

  changeisUpdate() {
    this.isUpdated = false;
  }

  get JoyId() {
    return this.joyUpdateForm.get('joy_id');
  }

  get JoyName() {
    return this.joyUpdateForm.get('joy_name');
  }

  get JoyDescription() {
    return this.joyUpdateForm.get('joy_desc');
  }

  get JoyFlag() {
    return this.joyUpdateForm.get('joy_flag');
  }  
  
  get JoyImgUrl() {
    return this.joyUpdateForm.get('joy_img_url');
  }
}