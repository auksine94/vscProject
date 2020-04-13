import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { JoyService } from '../joy.service';
import { Joy } from '../joy';

@Component({
  selector: 'app-add-joy',
  templateUrl: './add-joy.component.html'
})
export class AddJoyComponent implements OnInit {

  constructor(private joyservice: JoyService) { }

  joy: Joy = new Joy();
  submitted = false;

  ngOnInit() {
    console.log("ngOnInit");
    this.submitted = false;
  }

  addJoyForm() {
    console.log("addJoyForm");
    this.submitted = false;
    this.joySaveForm.reset();
  }

  joySaveForm = new FormGroup({
    joy_name: new FormControl('', [Validators.required, Validators.minLength(3)]),
    joy_desc: new FormControl('', [Validators.required]),
    joy_flag: new FormControl(),
    joy_img_url: new FormControl(),
  });

  createJoy(createJoy) {
    console.log("createJoy");
    this.joy = new Joy();
    this.joy.joy_name = this.JoyName.value;
    this.joy.joy_desc = this.JoyDescription.value;
    this.joy.joy_flag = this.JoyFlag.value;
    this.joy.joy_img_url = this.JoyImgUrl.value;
    this.submitted = true;
    this.create();
  }

  create() {
    this.joyservice.createJoy(this.joy)
      .subscribe(data => console.log(data), error => console.log(error));
    this.joy = new Joy();
  }

  get JoyName() {
    return this.joySaveForm.get('joy_name');
  }

  get JoyDescription() {
    return this.joySaveForm.get('joy_desc');
  }

  get JoyFlag() {
    return this.joySaveForm.get('joy_flag');
  }

  get JoyImgUrl() {
    return this.joySaveForm.get('joy_img_url');
  }
}