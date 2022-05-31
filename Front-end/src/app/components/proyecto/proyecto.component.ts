import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Proyecto } from 'src/app/model/project';
import { ProyectoService } from 'src/app/service/project.service';


@Component({
  selector: 'app-proyecto',
  templateUrl: './proyecto.component.html',
  styleUrls: ['./proyecto.component.css']
})
export class ProyectoComponent implements OnInit {

  public proyectos: Proyecto[] = [];
  public editProject: Proyecto | undefined;
  public deleteProject: Proyecto | undefined;


  constructor(private proyectoService: ProyectoService) { }

  ngOnInit(): void {
    this.getProyectos();
  }

  public getProyectos(): void {
    this.proyectoService.getProject().subscribe({
      next: (Response: Proyecto[]) => {
        this.proyectos = Response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }
  public onOpenModal(mode: String, project?: Proyecto): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addProyectoModal');
    } else if (mode === 'delete') {
      this.deleteProject = project;
      button.setAttribute('data-target', '#deleteProyectoModal');
    } else if (mode === 'edit') {
      this.editProject = project;
      button.setAttribute('data-target', '#editProyectoModal');
    }
    container?.appendChild(button);
    button.click();

  }
  public onAddProyecto(addForm: NgForm) {
    document.getElementById('add-proyecto-form')?.click();
    this.proyectoService.addProject(addForm.value).subscribe({
      next: (response: Proyecto) => {
        console.log(response);
        this.getProyectos();
        addForm.reset();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    })
  }
  public onUpdateProyecto(proyecto: Proyecto) {
    this.editProject = proyecto;
    document.getElementById('add-proyecto-form')?.click();
    this.proyectoService.updateProject(proyecto).subscribe({
      next: (response: Proyecto) => {
        console.log(response);
        this.getProyectos();

      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }
  public onDeleteProyecto(idPro: number): void {

    this.proyectoService.deleteProject(idPro).subscribe({
      next: (response: void) => {
        console.log(response);
        this.getProyectos();

      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }

}