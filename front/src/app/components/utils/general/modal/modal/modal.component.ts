import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { IModalParams } from 'src/app/interfaces/modal/Imodal-params';

@Component({
  selector: 'modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  //To send data from the new course component to the course page we
  //need to use @Output and create a new event emitter
  @Output() sendModalResponse = new EventEmitter();

  onSubmit(form:any):void{
    let empty:boolean=false;
    for(let i=0;i<form.length-1;i++){
      if(form[i].value=="")empty=true;
    }
    if(!empty){
      this.sendModalResponse.emit(form);
      for(let i=0;i<form.length-1&&form[i].localName!="select";i++){
        form[i].value="";
      }
    }
    
  }

  hide(e:any):void{
    if((e.target.className=='modalShadow2'||e.target.className=='close')&&!this.params.hidden)this.params.hidden=!this.params.hidden;
  }

  @Input() params:IModalParams = {
    title: '',
    id: '',
    formParams: {
      hidden:[],
      inputs: [],
      selects: []
    },
    footer: '',
    hidden: true
  };
}
