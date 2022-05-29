import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Proyecto } from '../model/project';

@Injectable({
  providedIn: 'root'
})
export class ProyectoService {
  [x: string]: any;
  private apiServerUrl=environment.apiBaseUrl;

  constructor(private http:HttpClient) { }

  public getProject():Observable<Proyecto[]>{
    return this.http.get<Proyecto[]>(`${this.apiServerUrl}/api/proyecto/all`);
  }
  public addProject(proyecto: Proyecto):Observable<Proyecto>{
    return this.http.post<Proyecto>(`${this.apiServerUrl}/api/proyecto/add`,proyecto);
  }
  public updateProject(proyecto: Proyecto):Observable<Proyecto>{
    return this.http.put<Proyecto>(`${this.apiServerUrl}/api/proyecto/update`,proyecto);
  }
  public deleteProject(proyectoId: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/api/proyecto/delete/${proyectoId}`);
  }
}