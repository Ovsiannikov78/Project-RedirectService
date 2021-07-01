import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
@Component({
  selector: 'app-short-url',
  templateUrl: './short-url.component.html',
  styleUrls: ['./short-url.component.css']
})
export class ShortUrlComponent implements OnInit {
  shortUrl: string;

  private redirectUrl = 'http://localhost:8090/';

  url: string | undefined;

  constructor(private route: ActivatedRoute) {
  }
  ngOnInit(): void {
    this.shortUrl = this.route.snapshot.paramMap.get('shortUrlId');
    this.url = this.redirectUrl + this.shortUrl;
  }
  redirectToTheLongUrl(): void {
    window.location.href = this.url;
  }
}
