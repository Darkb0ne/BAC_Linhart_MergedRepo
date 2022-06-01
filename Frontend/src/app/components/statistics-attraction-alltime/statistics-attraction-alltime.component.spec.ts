import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticsAttractionAlltimeComponent } from './statistics-attraction-alltime.component';

describe('StatisticsAttractionAlltimeComponent', () => {
  let component: StatisticsAttractionAlltimeComponent;
  let fixture: ComponentFixture<StatisticsAttractionAlltimeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatisticsAttractionAlltimeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StatisticsAttractionAlltimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
