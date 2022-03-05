import { Component, Input, OnInit } from '@angular/core';
import { IlabelInput } from 'src/app/interfaces/modal/Ilabel-input';

@Component({
  selector: 'label-input',
  templateUrl: './label-input.component.html',
  styleUrls: ['./label-input.component.css']
})
export class LabelInputComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Input() input:IlabelInput = {
    name: '',
    title: '',
    id: '',
    value:'',
    type: ''
  };

}
