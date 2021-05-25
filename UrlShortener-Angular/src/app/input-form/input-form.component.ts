import {Component, OnInit, Output} from '@angular/core';
import {LongUrl} from '../model/long-url';
import {ShortUrl} from '../model/short-url';
import {UrlService} from '../services/url.service';
import {Observable, Subscription} from 'rxjs';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-input-form',
  templateUrl: './input-form.component.html',
  styleUrls: ['./input-form.component.css']
})
export class InputFormComponent implements OnInit {

  // TODO find working Regex

  private urlReg = /(^|\s)((https?:\/\/)?[\w-]+(\.[\w-]+)+\.?(:\d+)?(\/\S*)?)/gi;

  form: FormGroup;
  longUrl: LongUrl = {};
  @Output() shortUrl: Observable<ShortUrl>;

  constructor(private urlService: UrlService) {
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      customer_number: new FormControl('', [
        Validators.required,
        Validators.minLength(1)
      ]),
      url_input: new FormControl('', [
        Validators.required,
        Validators.pattern(this.urlReg)
      ]),
      expiration_date_input: new FormControl('')
      }
    );
  }

  createShortUrl(): void {
    console.log('Form submitted: ', this.form);
    const formData = {...this.form.value};
    console.log('Form Data: ', formData);

    this.urlService.generateShortUrl(this.longUrl).subscribe(
      data => {
        this.urlService.shortUrl = data;
      }
    );
  }
}
