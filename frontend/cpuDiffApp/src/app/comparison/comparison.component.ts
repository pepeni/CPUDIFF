import { Component, OnInit } from '@angular/core';
import { Processor } from '../processor';
import { HttpErrorResponse } from '@angular/common/http';
import { ProcessorService } from '../processor.service';

@Component({
  selector: 'app-comparison',
  templateUrl: './comparison.component.html',
  styleUrls: ['./comparison.component.css']
})
export class ComparisonComponent implements OnInit{
  public processors: Processor[];
  public processor1: Processor;
  public processor2: Processor;

  constructor(private processorService: ProcessorService){}

  ngOnInit(): void {
    this.getProcessors();
  }

  public getProcessors(): void {
    this.processorService.getProcessors().subscribe(
      (response: Processor[]) => {
        this.processors = response;
        this.processor1 = response[0];
        this.processor2 = response[0];
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
