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
  public processor1: Processor;
  public selectedProcessor1Id: number;

  constructor(private processorService: ProcessorService){}

  ngOnInit(): void {
    this.getProcessors();
  }

  public getProcessors(): void {
    this.processorService.getProcessors().subscribe(
      (response: Processor[]) => {
        this.processors = response;
        if (response.length > 0) {
          this.processor1 = response[0];
          this.selectedProcessor1Id = response[0].id;
        }
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onProcessor1Change(): void {
    const selectedProcessor = this.processors.find(processor => processor.id == this.selectedProcessor1Id);
    console.log(selectedProcessor);
    if (selectedProcessor) {
      this.processor1 = selectedProcessor;
    }
  }

}
