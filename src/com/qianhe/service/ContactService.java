package com.qianhe.service;

import com.qianhe.model.Contact;

public abstract interface ContactService
{
  public abstract Contact getAllContact();

public abstract void updateContact(Contact contact);
}

