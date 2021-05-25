import { Component, OnInit } from '@angular/core';
import {UrlService} from '../services/url.service';
import {ShortUrl} from '../model/short-url';
import {LongUrl} from '../model/long-url';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-short-url',
  templateUrl: './short-url.component.html',
  styleUrls: ['./short-url.component.css']
})
export class ShortUrlComponent implements OnInit {

  shortLink: ShortUrl;

  private redirectUrl = 'http://localhost:8090/';

  constructor(private urlService: UrlService,
              private http: HttpClient,
              private router: Router) { }


  ngOnInit(): void {
    this.shortLink = this.urlService.shortUrl;
    console.log('ShortUrlLink from short-url-component ', this.shortLink);
  }

  redirectToTheLongUrl(): void {
    this.http.get<void>(this.redirectUrl + this.shortLink.shortUrl);
  }
}
