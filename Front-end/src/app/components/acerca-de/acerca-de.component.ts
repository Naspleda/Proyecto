import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Usuario } from 'src/app/model/usuario';
import { UsuarioService } from 'src/app/service/usuario.service';


@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {

  public usuario: Usuario | undefined;
  public editUsuario: Usuario | undefined;
  public deleteUsuario: Usuario | undefined;


  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.getUser();
  }

  public getUser(): void {
    this.usuarioService.getUser().subscribe({
      next: (response: Usuario) => {
        this.usuario = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }
  public onOpenModal(mode: String, usuario?: Usuario): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addUsuarioModal');
    } else if (mode === 'delete') {
      this.deleteUsuario = usuario;
      button.setAttribute('data-target', '#deleteUsuarioModal');
    } else if (mode === 'edit') {
      this.editUsuario = usuario;
      button.setAttribute('data-target', '#editUsuarioModal');
    }
    container?.appendChild(button);
    button.click();

  }

  public onAddUsuario(addForm: NgForm) {
    document.getElementById('add-usuario-form')?.click();
    this.usuarioService.addUsuario(addForm.value).subscribe({
      next: (response: Usuario) => {
        console.log(response);
        this.getUser();
        addForm.reset();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    })
  }

  public onUpdateUsuario(usuario: Usuario) {
    this.editUsuario = usuario;
    document.getElementById('add-usuario-form')?.click();
    this.usuarioService.updateUsuario(usuario).subscribe({
      next: (response: Usuario) => {
        console.log(response);
        this.getUser();

      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }

}
