import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Experiencia } from "../model/experience";

@Injectable({
  providedIn: 'root'
})
export class ExperienciaService {
  [x: string]: any;
  private apiServerUrl=environment.apiBaseUrl;

  constructor(private http:HttpClient) { }

  public getExperience():Observable<Experiencia[]>{
    return this.http.get<Experiencia[]>(`${this.apiServerUrl}/api/experiencia/all`);
  }
  public addExperience(experiencia: Experiencia):Observable<Experiencia>{
    return this.http.post<Experiencia>(`${this.apiServerUrl}/api/experiencia/add`,experiencia);
  }
  public updateExperience(experiencia: Experiencia):Observable<Experiencia>{
    return this.http.put<Experiencia>(`${this.apiServerUrl}/api/experiencia/update`,experiencia);
  }
  public deleteExperience(experienciaId: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/api/experiencia/delete/${experienciaId}`);
  }


  
}