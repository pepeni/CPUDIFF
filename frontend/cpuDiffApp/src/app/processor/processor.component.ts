import { Component, OnInit } from '@angular/core';
import { Processor } from '../processor';
import { ProcessorService } from '../processor.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-processor',
  templateUrl: './processor.component.html',
  styleUrls: ['./processor.component.css']
})
export class ProcessorComponent implements OnInit{

  public processors: Processor[];

  constructor(private processorService: ProcessorService){}

  ngOnInit(): void {
    this.getProcessors();
  }

  public getProcessors(): void {
    this.processorService.getProcessors().subscribe(
      (response: Processor[]) => {
        this.processors = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
