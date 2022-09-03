import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Message } from '../message';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css'],
})
export class MessageComponent implements OnInit {
  messages: Message[] | undefined;
  filterTerm!: string;
  message: Message = new Message();

  constructor(private messageService: MessageService) {}

  ngOnInit() {
    this.messageService.findAll().subscribe((data) => {
      this.messages = data;
    });
  }
  // deleteMessage(smbMessageId: Array<any>) {
  //   this.messageService.delete(smbMessageId).subscribe((data) => {
  //     console.log('deleted response', data);
  //     this.listMessages();
  //   });
  // }
  // calculateData(date: string): any {
  //   let dateCreate: any;

  //   dateCreate = new Date(date);
  //   let Now: any = new Date();

  //   let finalMonth: any = Now.getMonth() - dateCreate.getMonth();
  //   let finlaDay = Now.getDay() - dateCreate.getDay();
  //   let finlHours = Now.getHours() - dateCreate.getHours();
  //   let finlMinutes = Now.getMinutes() - dateCreate.getMinutes();
  //   let finlSeconds = Now.getSeconds() - dateCreate.getSeconds();
  //   if (finalMonth > 0) {
  //     return finalMonth + ' months ago';
  //   }
  //   if (finlaDay > 0) {
  //     return finlaDay + ' days ago';
  //   }
  //   if (finlHours > 0) {
  //     return finlHours + ' hours ago';
  //   }
  //   if (finlMinutes > 0) {
  //     return finlMinutes + ' minutes ago';
  //   }
  //   if (finlSeconds > 0) {
  //     return finlSeconds + ' seconds ago';
  //   }
  // }
  parseDate(date: string): any {
    let dateCreate = new Date(date);
    return (
      dateCreate.getDate() +
      '/' +
      dateCreate.getMonth() +
      '/' +
      dateCreate.getFullYear() +
      ' ' +
      dateCreate.getHours() +
      ':' +
      dateCreate.getMinutes() +
      ':' +
      dateCreate.getSeconds() +
      ':' +
      dateCreate.getMilliseconds()
    );
  }
  listMessages() {
    this.messageService.findAll().subscribe((data) => (this.messages = data));
  }
  reload() {
    window.location.reload();
  }
}
