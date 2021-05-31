import {Component, OnInit, Output} from '@angular/core';
import {LongUrl} from '../model/long-url';
import {ShortUrl} from '../model/short-url';
import {UrlService} from '../services/url.service';
import {Observable, Subscription} from 'rxjs';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-input-form',
  templateUrl: './input-form.component.html',
  styleUrls: ['./input-form.component.css']
})
export class InputFormComponent implements OnInit {

  private urlReg = /(^|\s)((https?:\/\/)?[\w-]+(\.[\w-]+)+\.?(:\d+)?(\/\S*)?)/gi;

  form: FormGroup;
  longUrl: LongUrl = {};
  @Output() shortUrl: Observable<ShortUrl>;

  constructor(private urlService: UrlService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      customer_number: new FormControl('', [
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(10)
      ]),
      url_input: new FormControl('', [
        Validators.required,
        Validators.pattern(this.urlReg),
        Validators.maxLength(255)
      ]),
      expiration_date_input: new FormControl('', [
          Validators.maxLength(100)
      ])
      }
    );
  }

  createShortUrl(): void {

    this.urlService.generateShortUrl(this.longUrl).subscribe(
        data => {
          this.urlService.shortUrl = data;
          this.router.navigate(['urls/shorturl']);
        }, error => console.log(error)
    );
  }
}

