/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.jvm.lower

import org.jetbrains.kotlin.backend.common.BodyLoweringPass
import org.jetbrains.kotlin.backend.jvm.JvmBackendContext
import org.jetbrains.kotlin.ir.expressions.IrBody
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.IrGetEnumValue
import org.jetbrains.kotlin.ir.expressions.IrGetObjectValue
import org.jetbrains.kotlin.ir.visitors.IrElementTransformerVoid
import org.jetbrains.kotlin.ir.visitors.transformChildrenVoid

class SingletonReferencesLowering(val context: JvmBackendContext) : BodyLoweringPass, IrElementTransformerVoid() {
    override fun lower(irBody: IrBody) {
        irBody.transformChildrenVoid(this)
    }

    override fun visitGetEnumValue(expression: IrGetEnumValue): IrExpression {
        val entrySymbol = context.descriptorsFactory.getSymbolForEnumEntry(expression.symbol)
        return TODO()
    }

    override fun visitGetObjectValue(expression: IrGetObjectValue): IrExpression {
        val instanceField = context.descriptorsFactory.getSymbolForObjectInstance(expression.symbol)
        return TODO()
    }
}