//
//  ViewFactory.swift
//  iosApp
//
//  Created by Daan Klarenbeek on 10/12/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Presentation
import SwiftUI

class ViewFactory: NativeViewFactory {
    func selectMenuFactory(
        title: String,
        colors: SelectMenuColors,
        options: [SelectMenuOption<AnyObject>],
        selected: SelectMenuOption<AnyObject>,
        onSelect: @escaping (SelectMenuOption<AnyObject>) -> Void,
    ) -> UIViewController {
        let selectMenuView = SelectMenuView(
            title: title,
            colors: colors,
            options: options,
            selected: selected,
            onSelect: onSelect,
        )
        
        let controller = UIHostingController(rootView: selectMenuView)
        controller.view.backgroundColor = .clear

        return controller
    }

    func dialogFactory(title: String, description: String?, actions: [DialogAction]) -> UIViewController {
        let dialogView = DialogView(title: title, description: description, actions: actions)
        let controller = UIHostingController(rootView: dialogView)
        controller.view.backgroundColor = .clear

        return controller
    }
}
