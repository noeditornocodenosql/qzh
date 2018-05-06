package com.qianhe.mapper;

import com.qianhe.model.Contact;

public abstract interface ContactMapper
{
  public abstract Contact getAllContact();

  public abstract void updateContact(Contact contact);
}

