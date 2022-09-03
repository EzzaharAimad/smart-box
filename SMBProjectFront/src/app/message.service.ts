import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Message } from './message';

@Injectable()
export class MessageService {
  private messagesUrl: string;

  constructor(private http: HttpClient) {
    this.messagesUrl = 'https://localhost:8443/message';
  }

  public findAll(): Observable<Message[]> {
    return this.http.get<Message[]>(this.messagesUrl);
  }

  public save(message: Message) {
    return this.http.post<Message>(this.messagesUrl, message);
  }

  // public delete(smbMessageId: Array<any>): Observable<any> {
  //   return this.http.delete(`${this.messagesUrl}/${smbMessageId}`, {
  //     responseType: 'text',
  //   });
  // }
}
