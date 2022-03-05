import { Component, Input, OnInit } from '@angular/core';
import { IlabelSelect } from 'src/app/interfaces/modal/Ilabel-select';

@Component({
  selector: 'label-select',
  templateUrl: './label-select.component.html',
  styleUrls: ['./label-select.component.css']
})
export class LabelSelectComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Input() select:IlabelSelect = {
    name: '',
    title: '',
    id: '',
    options: [{value:0,title:''}]
  };

}
