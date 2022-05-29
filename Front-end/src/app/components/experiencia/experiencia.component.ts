import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Experiencia } from 'src/app/model/experience';
import { ExperienciaService } from 'src/app/service/experiencia.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {

  public experiencias:Experiencia[]=[];
  public editExperience: Experiencia | undefined;
  public deleteExperience: Experiencia | undefined;


  constructor(private experienciaService: ExperienciaService) { }

  ngOnInit(): void {
    this.getExperiencias();
  }

  public getExperiencias():void{
    this.experienciaService.getExperience().subscribe({
      next:(Response: Experiencia[]) =>{
        this.experiencias=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }
  public onOpenModal(mode:String, experience?: Experiencia):void{
    const container=document.getElementById('main-container');
    const button=document.createElement('button');
    button.style.display='none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target','#addExperienceModal');
    }else if(mode==='delete'){
      this.deleteExperience=experience;
      button.setAttribute('data-target','#deleteExperienciaModal');
    }else if(mode==='edit'){
      this.editExperience=experience;
      button.setAttribute('data-target','#editExperienciaModal');
    }
    container?.appendChild(button);
    button.click();

    }
    public onAddExperiencia(addForm: NgForm){
      document.getElementById('add-experiencia-form')?.click();
      this.experienciaService.addExperience(addForm.value).subscribe({
        next: (response:Experiencia) =>{
          console.log(response);
          this.getExperiencias();
          addForm.reset();
        },
        error:(error:HttpErrorResponse)=>{
          alert(error.message);
          addForm.reset();
        }
      })
    }
    public onUpdateExperiencia(experiencia : Experiencia){
      this.editExperience=experiencia;
      document.getElementById('add-experiencia-form')?.click();
      this.experienciaService.updateExperience(experiencia).subscribe({
        next: (response:Experiencia) =>{
          console.log(response);
          this.getExperiencias();
          
        },
        error:(error:HttpErrorResponse)=>{
          alert(error.message);
        }
      })
    }
    public onDeleteExperiencia(idExp: number):void{

      this.experienciaService.deleteExperience(idExp).subscribe({
        next: (response:void) =>{
          console.log(response);
          this.getExperiencias();
          
        },
        error:(error:HttpErrorResponse)=>{
          alert(error.message);
        }
      })
    }

  }