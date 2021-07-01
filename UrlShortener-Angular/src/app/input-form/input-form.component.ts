import {Component, OnInit, Output} from '@angular/core';
import {LongUrl} from '../model/long-url';
import {ShortUrl} from '../model/short-url';
import {UrlService} from '../services/url.service';
import {Observable} from 'rxjs';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
    selector: 'app-input-form',
    templateUrl: './input-form.component.html',
    styleUrls: ['./input-form.component.css']
})
export class InputFormComponent implements OnInit {

    form: FormGroup;
    longUrl: LongUrl = {};

    @Output()
    shortUrl: Observable<ShortUrl>;

    constructor(private urlService: UrlService,
                private router: Router,
                private builder: FormBuilder) {
    }

    ngOnInit(): void {
        const urlReg = /(^|\s)((https?:\/\/)?[\w-]+(\.[\w-]+)+\.?(:\d+)?(\/\S*)?)/gi;
        this.form = this.builder.group({
                customerNumber: [null,
                    [
                        Validators.required,
                        Validators.minLength(1),
                        Validators.maxLength(10)
                    ]
                ],
                urlInput: [null,
                    [
                        Validators.required,
                        Validators.pattern(urlReg),
                        Validators.maxLength(255)
                    ]
                ],
                expirationDateInput: [null,
                    [Validators.maxLength(100)]
                ]
            }
        );
    }

    createShortUrl(): void {
        this.longUrl.longUrl = this.form.controls.urlInput.value;
        this.longUrl.customerNumber = this.form.controls.customerNumber.value;
        this.longUrl.expirationDate = this.form.controls.expirationDateInput.value;

        this.urlService.generateShortUrl(this.longUrl).subscribe(
            data => {
                this.router.navigate(['urls', data.shortUrl]);
            }, error => console.log(error)
        );
    }
}

