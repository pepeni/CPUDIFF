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
