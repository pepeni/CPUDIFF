import { Component, OnInit } from '@angular/core';
import { Processor } from '../models/processor';
import { HttpErrorResponse } from '@angular/common/http';
import { ProcessorService } from '../services/processor.service';

@Component({
  selector: 'app-comparison',
  templateUrl: './comparison.component.html',
  styleUrls: ['./comparison.component.css']
})
export class ComparisonComponent implements OnInit{
  public processors: Processor[];
  public processor1: Processor;
  public processor2: Processor;
  public selectedProcessor1Id: number;
  public selectedProcessor2Id: number;

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
          this.processor2 = response[0];
          this.selectedProcessor1Id = response[0].id;
          this.selectedProcessor2Id = response[0].id;
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
  
  public onProcessor2Change(): void {
    const selectedProcessor = this.processors.find(processor => processor.id == this.selectedProcessor2Id);
    if (selectedProcessor) {
      this.processor2 = selectedProcessor;
    }
  }

}
