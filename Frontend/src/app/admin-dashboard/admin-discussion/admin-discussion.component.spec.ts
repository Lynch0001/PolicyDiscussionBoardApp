import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDiscussionComponent } from './admin-discussion.component';

describe('AdminDiscussionComponent', () => {
  let component: AdminDiscussionComponent;
  let fixture: ComponentFixture<AdminDiscussionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminDiscussionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDiscussionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
