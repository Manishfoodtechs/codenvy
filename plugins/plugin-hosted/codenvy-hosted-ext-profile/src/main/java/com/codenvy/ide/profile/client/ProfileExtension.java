/*
 * Copyright (c) [2012] - [2017] Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package com.codenvy.ide.profile.client;

import com.codenvy.ide.profile.client.action.RedirectToDashboardAccountAction;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.action.DefaultActionGroup;
import org.eclipse.che.ide.api.action.IdeActions;
import org.eclipse.che.ide.api.constraints.Anchor;
import org.eclipse.che.ide.api.constraints.Constraints;
import org.eclipse.che.ide.api.extension.Extension;

/**
 * Extension which add profile menu
 *
 * @author Oleksii Orel
 */
@Singleton
@Extension(title = "Profile", version = "1.0.0")
public class ProfileExtension {

  /** Create extension. */
  @Inject
  public ProfileExtension(
      ActionManager actionManager,
      RedirectToDashboardAccountAction redirectToDashboardAccountAction,
      ProfileLocalizationConstant localizationConstant) {

    actionManager.registerAction(
        localizationConstant.redirectToDashboardAccountAction(), redirectToDashboardAccountAction);
    Constraints constraint = new Constraints(Anchor.FIRST, null);
    DefaultActionGroup profileActionGroup =
        (DefaultActionGroup) actionManager.getAction(IdeActions.GROUP_PROFILE);
    profileActionGroup.add(redirectToDashboardAccountAction, constraint);
  }
}
