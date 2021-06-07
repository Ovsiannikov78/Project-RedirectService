import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {LongUrl} from '../model/long-url';
import {Observable} from 'rxjs';
import {ShortUrl} from '../model/short-url';


@Injectable({
  providedIn: 'root'
})
export class UrlService {

  shortUrl: ShortUrl;

  private inputFormUrl = 'http://localhost:8090/urls';

  constructor(private http: HttpClient) { }


  generateShortUrl(longUrl: LongUrl): Observable<ShortUrl> {
   return this.http.post<ShortUrl>(this.inputFormUrl, longUrl);
  }
}
