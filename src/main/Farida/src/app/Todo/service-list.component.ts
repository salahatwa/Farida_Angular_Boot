import { Component, Input, OnInit } from '@angular/core';
import { TodoService } from './todo.service';
import { NgForm } from '@angular/forms';
import { Service } from '../models/service';
import { ServiceStack } from '../utils/service-stack.enum';

@Component({
  selector: 'app-todo-list',
  templateUrl: './service-list.component.html'
})

export class ServiceListComponent implements OnInit {
  services: Service[];
  newService: Service = new Service();
  editing: Boolean = false;
  editingService: Service = new Service();

  type: ServiceStack;

  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
    this.getTodos();
  }

  getTodos(): void {
    this.todoService.getTodos()
      .then(todos => this.services = todos);
  }

  createTodo(todoForm: NgForm): void {
    this.todoService.createTodo(this.newService)
      .then(createTodo => {
        todoForm.reset();
        this.newService = new Service();
        this.services.unshift(createTodo);
      });
  }

  deleteTodo(id: Number): void {
    this.todoService.deleteTodo(id)
      .then(() => {
        this.services = this.services.filter(todo => todo.id !== id);
      });
  }

  updateTodo(todoData: Service): void {
    console.log(todoData);
    this.todoService.updateTodo(todoData)
      .then(updatedTodo => {
        const existingTodo = this.services.find(todo => todo.id === updatedTodo.id);
        Object.assign(existingTodo, updatedTodo);
        this.clearEditing();
      });
  }

  toggleCompleted(todoData: Service): void {
    // todoData.completed = !todoData.completed;
    this.todoService.updateTodo(todoData)
      .then(updatedTodo => {
        const existingTodo = this.services.find(todo => todo.id === updatedTodo.id);
        Object.assign(existingTodo, updatedTodo);
      });
  }

  editTodo(todoData: Service): void {
    this.editing = true;
    Object.assign(this.editingService, todoData);
  }

  clearEditing(): void {
    this.editingService = new Service();
    this.editing = false;
  }
}
