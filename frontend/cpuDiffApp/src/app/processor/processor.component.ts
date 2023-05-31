import { Component, OnInit } from '@angular/core';
import { Processor } from '../models/processor';
import { ProcessorService } from '../services/processor.service';
import { HttpErrorResponse } from '@angular/common/http';
import { CommentService } from '../services/comment.service';
import { Comment } from '../models/comment';

@Component({
  selector: 'app-processor',
  templateUrl: './processor.component.html',
  styleUrls: ['./processor.component.css']
})
export class ProcessorComponent implements OnInit{

  public processors: Processor[];
  public processor1: Processor;
  public selectedProcessor1Id: number;
  public comments: Comment[];
  public newComment: string;

  constructor(private processorService: ProcessorService, private commentService: CommentService){}

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
          this.getProcessorComments();
        }

      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getProcessorComments(): void{
    this.commentService.getProcessorComments(this.processor1.id).subscribe(
      (response: Comment[]) => {
        this.comments = response;
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
      this.getProcessorComments();
    }
  }

  public addComment(): void {
    if (this.newComment && this.newComment.trim() !== '') {
      const comment: Object = {
        processorId: this.processor1.id,
        content: this.newComment
      };
      console.log(comment);
      this.commentService.addProcessorComment(comment).subscribe();
      
      this.newComment = '';
      this.getProcessorComments();
    }
  }

}
