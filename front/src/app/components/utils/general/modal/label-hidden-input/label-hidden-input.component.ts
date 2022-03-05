import { Component, Input, OnInit } from '@angular/core';
import { IlabelHiddenInput } from 'src/app/interfaces/modal/Ilabel-hidden-input';

@Component({
  selector: 'label-hidden-input',
  templateUrl: './label-hidden-input.component.html',
  styleUrls: ['./label-hidden-input.component.css']
})
export class LabelHiddenInputComponent implements OnInit {

  value:string="";

  constructor() { }

  ngOnInit() {
    this.value=this.hiddenInput.input.value||"";
  }
  @Input() hiddenInput:IlabelHiddenInput = {
    hidden:true,
    input: {
      name: '',
      title: '',
      value:'',
      id: '',
      type: ''
    }
  };

  hide():void{
    this.hiddenInput.hidden=!this.hiddenInput.hidden;
    this.hiddenInput.input.value=this.value;
  }

}
