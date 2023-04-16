import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { Processor } from './processor';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProcessorService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getProcessors(): Observable<Processor[]> {
    return this.http.get<Processor[]>(`${this.apiServerUrl}/allProcessors`)
  }

  public getProcessor(id: number): Observable<Processor> {
    return this.http.get<Processor>(`${this.apiServerUrl}/processor/${id}`)
  }

  public addProcessor(processor: Processor): Observable<Processor> {
    return this.http.post<Processor>(`${this.apiServerUrl}/addProcessor`, processor)
  }

  public updateProcessor(processor: Processor): Observable<Processor> {
    return this.http.put<Processor>(`${this.apiServerUrl}/updateProcessor`, processor)
  }

  public deleteProcessor(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/deleteProcessor/${id}`)
  }
}
