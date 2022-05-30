import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { environment } from 'src/environments/environment';
import { Educacion } from '../model/education';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {
  [x: string]: any;
  private apiServerUrl="https://apcen.herokuapp.com";

  constructor(private http:HttpClient) { }

  public getEducation():Observable<Educacion[]>{
    return this.http.get<Educacion[]>(`${this.apiServerUrl}/api/educacion/all`);
  }
  public addEducacion(educacion: Educacion):Observable<Educacion>{
    return this.http.post<Educacion>(`${this.apiServerUrl}/api/educacion/add`,educacion);
  }
  public updateEducacion(educacion: Educacion):Observable<Educacion>{
    return this.http.put<Educacion>(`${this.apiServerUrl}/api/educacion/update`,educacion);
  }
  public deleteEducacion(educacionId: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/api/educacion/delete/${educacionId}`);
  }


  
}
